import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DemoCon {
    @Autowired
    public KafkaTemplate<String, String> oKafkaTemplate;

    private static final String TOPIC ="test";

    @GetMapping("/publish/{message}")

    public String publishMessage(@PathVariable("Message") final String message)
    {
        oKafkaTemplate.send(TOPIC, message);
        return "Published Successful";
    }
}
