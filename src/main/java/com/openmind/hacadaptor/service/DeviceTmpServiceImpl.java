package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.dao.DeviceTmpMapper;
import com.openmind.hacadaptor.model.*;
import com.openmind.hacadaptor.socket.hacoperation.IOperator;
import com.openmind.hacadaptor.socket.xml.model.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.model.devices.SAccount;
import com.openmind.hacadaptor.socket.xml.model.devices.SDevice;
import com.openmind.hacadaptor.socket.xml.model.devices.SPort;
import com.openmind.hacadaptor.sqlutil.IdWorker;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuBin
 * @version Created on 2017/7/24
 */
@Service
public class DeviceTmpServiceImpl extends BaseServiceImp<DeviceTmp, Identity> implements IDeviceTmpService {
    Logger logger = Logger.getLogger(DeviceTmpServiceImpl.class);
    @Autowired
    private IOperator deviceOperation;
    @Autowired
    private PortServiceImpl portService;
    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private DeviceTmpMapper deviceTmpMapper;

    /**
     * @return
     * @throws RuntimeException to make sure the transaction will roll back
     */
    @Transactional
    public Result updateDeviceTmpFromHac() throws RuntimeException {
        Result result;
        XMLDTO xmldto = deviceOperation.getXmldtoBack();
        result = Result.getResult(xmldto);
        if (xmldto.getErrorCode() == 0) {
            List<SDevice> list = (List<SDevice>) xmldto.getResult().getBackContext().getContextDetail();
            List<Device> devices = new ArrayList<>();
            List<Port> ports = new ArrayList<>();
            List<Account> accounts = new ArrayList<>();
            int totalDevice = 0, totalPort = 0, totalAccount = 0;
            int countDevice = 0, countPort = 0, countAccount = 0;
            StringBuilder sb = new StringBuilder();

            try {
                if (list.size() > 0) {
                    for (SDevice sDevice : list) {
                        DeviceTmp device = new DeviceTmp(IdWorker.getId());
                        BeanUtils.copyProperties(sDevice, device);
                        List<SPort> sPorts = sDevice.getPort();
                        if (sPorts != null && sPorts.size() > 0)
                            for (SPort sPort : sPorts) {
                                Port port = new Port(IdWorker.getId());//Thread.sleep(1);
                                port.setDeviceId(sDevice.getDeviceId());
                                BeanUtils.copyProperties(sPort, port);
                                ports.add(port);
                            }
                        List<SAccount> sAccounts = sDevice.getAccount();
                        if (sAccounts != null && sAccounts.size() > 0)
                            for (SAccount sAccount : sAccounts) {
                                Account account = new Account(IdWorker.getId());//Thread.sleep(1);
                                account.setDeviceId(sDevice.getDeviceId());
                                BeanUtils.copyProperties(sAccount, account);
                                accounts.add(account);
                            }

                        devices.add(device);
                        logger.info("[FromHAC]:deviceId->" + device.getDeviceId());
                        countDevice = deviceTmpMapper.insert(device);
                        if (ports.size() > 0) {
                            logger.info("[FromHAC]:ports size->" + ports.size());
                            countPort = portService.insertBatch(ports);
                        }
                        if (accounts.size() > 0) {
                            logger.info("[FromHAC]:accounts size->" + accounts.size());
                            countAccount = accountService.insertBatch(accounts);
                        }
                        ports.clear();
                        accounts.clear();
                    }
                }

            } catch (Throwable e) {
                throw new RuntimeException(e);
            } finally {
                totalDevice += countDevice;
                totalPort += countPort;
                totalAccount += countAccount;
                sb.append("total device:").append(totalDevice).append("\n");
                sb.append("total port:").append(totalPort).append("\n");
                sb.append("total account:").append(totalAccount).append("\n");
                result.setMessage(sb.toString());

            }
        }
        return result;
    }

    @Override
    public List<DeviceTmp> getNewDevices()throws Throwable {
        return deviceTmpMapper.getNewDevices();
    }
}
