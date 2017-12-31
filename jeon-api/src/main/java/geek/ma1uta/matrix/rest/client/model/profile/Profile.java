package geek.ma1uta.matrix.rest.client.model.profile;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
public class Profile {

    private String avatarUrl;
    private String displayname;
}
