package com.clsaa.dop.server.link.service;

import com.clsaa.dop.server.link.dao.BindDao;
import com.clsaa.dop.server.link.enums.MonitorState;
import com.clsaa.dop.server.link.model.po.Bind;
import com.clsaa.dop.server.link.model.vo.BindVO;
import com.clsaa.dop.server.link.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BindService {

    @Autowired
    private BindDao bindDao;

    public List<BindVO> getList(long cuser) {
        List<Bind> res = bindDao.findByCuser(cuser);
        return convertToVo(res);
    }

    public void add(BindVO vo) {
        Bind newBind = new Bind();
        newBind.setTitle(vo.getTitle());
        newBind.setCuser(vo.getCuser());
        newBind.setCuserName(vo.getCuserName());
        newBind.setProjectId(vo.getProjectId());
        newBind.setProjectTitle(vo.getProjectTitle());
        newBind.setNotifiedUid(vo.getNotifiedUid());
        newBind.setNotifiedName(vo.getNotifiedName());
        newBind.setNotifiedEmail(vo.getNotifiedEmail());
        newBind.setService(vo.getService());
        newBind.setThreshold(vo.getThreshold());
        newBind.setState(MonitorState.FREE);
        newBind.setCtime(new Date());
        bindDao.save(newBind);
    }

    public void stop(long bid) {
        bindDao.stopBind(bid);
    }

    public void start(long bid) {
        bindDao.startBind(bid);
    }

    public void delete(long bid) {
        bindDao.deleteById(bid);
    }

    public void modify(Long bid,BindVO bindVO) {

    }

    private List<BindVO> convertToVo(List<Bind> binds) {
        List<BindVO> res = new ArrayList<>();
        for (Bind bind : binds) {
            res.add(BeanUtils.convertType(bind, BindVO.class));
        }
        return res;
    }

    private <T> String joinArray(T[] arr) {

        StringBuffer buffer = new StringBuffer();
        for (T item : arr) {
            buffer.append(item).append(",");
        }
        String result = buffer.toString();
        System.out.println("result: " + result);
        return result;
    }
}
