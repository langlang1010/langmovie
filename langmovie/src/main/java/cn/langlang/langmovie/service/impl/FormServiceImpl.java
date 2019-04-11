package cn.langlang.langmovie.service.impl;

import cn.langlang.langmovie.dao.FormDao;
import cn.langlang.langmovie.entity.Form;
import cn.langlang.langmovie.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private FormDao formDao;
    @Override
    public Long insertForm(Form form) {
        if(formDao.insertForm(form)>0) {
            return form.getPkFormid();
        }
        return -1L;
    }

    @Override
    public Form getFormById(Form form) {
        return formDao.getFormById(form);
    }

    @Override
    public int updateForm(Form form) {
        return formDao.updateForm(form);
    }

    @Override
    public int deleteForm(Form form) {
        return formDao.deleteForm(form);
    }

    @Override
    public List<Form> listForm(int page1, int num) {
        return formDao.listForm(page1-1,num);
    }

}
