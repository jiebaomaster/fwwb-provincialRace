package fwwb.classMoments.DTO;

/**
 * Created by hongcj on 2017/5/7.
 */
public class HonorWallDTO {
    private int id;

    private int users_id;

    private MomentDTO momentDTO;

    public HonorWallDTO() {
    }

    public HonorWallDTO(int id, int users_id, MomentDTO momentDTO) {
        this.id = id;
        this.users_id = users_id;
        this.momentDTO = momentDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public MomentDTO getMomentDTO() {
        return momentDTO;
    }

    public void setMomentDTO(MomentDTO momentDTO) {
        this.momentDTO = momentDTO;
    }
}
