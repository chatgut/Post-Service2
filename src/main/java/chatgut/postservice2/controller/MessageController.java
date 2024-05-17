package chatgut.postservice2.controller;

import chatgut.postservice2.entity.Message;
import chatgut.postservice2.repository.MessageDAO;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<Message> postMessage(@RequestBody Message message,
                                               @RequestHeader("userid") String userId) {
        // Set senderUsername from the request header
        message.setSenderUsername(userId);

        // Set receiverUsername from the message's 'to' field
        message.setReceiverUsername(message.getReceiverUsername());

        // Save the message
        Message savedMessage = messageDAO.postMessage(message);

        // Return the saved message with HTTP status CREATED
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") Long id) {
        // Retrieve message by id from messageDAO
        Message message = messageDAO.getMessageById(id);

        // Return the message with HTTP status OK
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
