package chatgut.postservice2.repository;

import chatgut.postservice2.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MessageDAOImpl implements MessageDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Message> rowMapper = new RowMapper<>() {
        @Override
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            Message message = new Message();
            message.setId(rs.getLong("id"));
            message.setSenderUsername(rs.getString("sender_username"));
            message.setReceiverUsername(rs.getString("receiver_username"));
            message.setMessage(rs.getString("message"));
            return message;
        }
    };

    @Override
    public Message getMessageById(Long id) {
        String sql = "SELECT * FROM message WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    @Override
    public Message postMessage(Message message) {
        String sql = "INSERT INTO message (sender_username, receiver_username, message) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, message.getSenderUsername(), message.getReceiverUsername(), message.getMessage());
        Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        message.setId(id);
        return message;
    }
}