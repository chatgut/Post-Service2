package chatgut.postservice2.repository;

import chatgut.postservice2.entity.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDAO {
    Message getMessageById(Long id);

    Message postMessage(Message message);
}
