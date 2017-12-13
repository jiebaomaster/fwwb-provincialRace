package fwwb.classMoments.DTO;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by hongcj on 2017/5/6.
 */
public class FavorDTO {
    private UserDTO userDTO;

    private MomentDTO momentDTO;

    private Timestamp createAt;

    public FavorDTO(UserDTO userDTO, MomentDTO momentDTO, Timestamp createAt) {
        this.userDTO = userDTO;
        this.momentDTO = momentDTO;
        this.createAt = createAt;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public MomentDTO getMomentDTO() {
        return momentDTO;
    }

    public void setMomentDTO(MomentDTO momentDTO) {
        this.momentDTO = momentDTO;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}
