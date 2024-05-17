package chatgut.postservice2.controller;

import chatgut.postservice2.entity.Message;
import chatgut.postservice2.repository.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")  // Base URL mapping
public class MessageController {

    @Autowired
    private MessageDAO messageDAO;

    @PostMapping
    public ResponseEntity<Message> postMessage(@RequestBody Message message) {
        return new ResponseEntity<>(messageDAO.postMessage(message), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(messageDAO.getMessageById(id), HttpStatus.OK);
    }
}
