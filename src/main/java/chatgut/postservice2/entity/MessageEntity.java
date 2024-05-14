package chatgut.postservice2.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "messages")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_username")
    private String senderUsername;

    @Column(name = "receiver_username")
    private String receiverUsername;

    @Column(name = "message")
    private String message;

    public MessageEntity() {}

    public MessageEntity(String senderUsername, String receiverUsername, String message) {
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}