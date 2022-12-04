package giaodienchuan.model.BackEnd.common;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class CommonDTO {

    @Id
    private ObjectId id;

}
