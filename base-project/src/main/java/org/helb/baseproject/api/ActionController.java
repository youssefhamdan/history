package org.helb.baseproject.api;


import org.helb.baseproject.model.entity.Action;
import org.helb.baseproject.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/actions")
public class ActionController {
    @Autowired
    ActionService actionService;

    @GetMapping("")
    public List<Action> list() {
        return actionService.listAllAction();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Action> get(@PathVariable Long id) {
        try {
            Action action = actionService.getAction(id);
            return new ResponseEntity<Action>(action, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Action>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public Action add(@RequestBody Action action) {
        return actionService.saveAction(action);
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Action action, @PathVariable Long id) {
        try {
            Action existUser = actionService.getAction(id);
            action.setId(id);
            actionService.saveAction(action);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        actionService.deleteAction(id);
    }
}
