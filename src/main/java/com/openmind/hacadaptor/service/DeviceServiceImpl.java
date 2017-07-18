package com.openmind.hacadaptor.service;

import com.openmind.hacadaptor.dao.AccountMapper;
import com.openmind.hacadaptor.dao.DeviceMapper;
import com.openmind.hacadaptor.dao.PortMapper;
import com.openmind.hacadaptor.mode.*;
import com.openmind.hacadaptor.socket.hacoperation.IOperator;
import com.openmind.hacadaptor.socket.xml.mode.common.XMLDTO;
import com.openmind.hacadaptor.socket.xml.mode.devices.SAccount;
import com.openmind.hacadaptor.socket.xml.mode.devices.SDevice;
import com.openmind.hacadaptor.socket.xml.mode.devices.SPort;
import com.openmind.hacadaptor.sqlutil.IdWorker;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuBin on 2017/6/22.
 */
@Service
public class DeviceServiceImpl extends BaseServiceImp<Device, Identity> implements IDeviceService {
    Logger logger = Logger.getLogger(DeviceServiceImpl.class);
    @Autowired
    private IOperator deviceOperation;
    @Autowired
    private PortMapper portMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private DeviceMapper deviceMapper;

    /**
     *
     * @return
     * @throws RuntimeException to make sure the transaction will roll back
     */
    @Transactional
    public Result updateDevicesFromHac() throws RuntimeException {
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
                        Device device = new Device(IdWorker.getId());

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
                                BeanUtils.copyProperties(sAccount, account);
                                accounts.add(account);
                            }

                        devices.add(device);

                        countDevice = deviceMapper.insert(device);
                        if (ports.size() > 0)
                            countPort = portMapper.insertBatch(ports);
                        if (accounts.size() > 0)
                            countAccount = accountMapper.insertBatch(accounts);
                        ports.clear();
                        accounts.clear();
                    }
                }

            } catch (Exception e) {
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

    /**
     *
     * @return All the devices in the certain group with ports and accounts
     */
    public Result getDevicesDetailsByGroupName(String groupName){

        return null;
    }

    public IOperator getDeviceOperation() {
        return deviceOperation;
    }

    public void setDeviceOperation(IOperator deviceOperation) {
        this.deviceOperation = deviceOperation;
    }

    public PortMapper getPortMapper() {
        return portMapper;
    }

    public void setPortMapper(PortMapper portMapper) {
        this.portMapper = portMapper;
    }

    public AccountMapper getAccountMapper() {
        return accountMapper;
    }

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public DeviceMapper getDeviceMapper() {
        return deviceMapper;
    }

    public void setDeviceMapper(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }
}
