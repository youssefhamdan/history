package org.helb.baseproject.service;


import org.helb.baseproject.model.entity.Action;
import org.helb.baseproject.repo.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
public class ActionService {
    @Autowired
    private ActionRepository actionRepository;
    public List<Action> listAllAction() {
        return actionRepository.findAll();
    }

    public Action saveAction(Action action) {
       return  actionRepository.save(action);
    }

    public Action getAction(Long id) {
        return actionRepository.findById(id).get();
    }

    public void deleteAction(Long id) {
        actionRepository.deleteById(id);
    }
}
