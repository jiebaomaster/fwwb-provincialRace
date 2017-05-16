package fwwb.classMoments.DTO;

import java.sql.Timestamp;

/**
 * Created by hongcj on 2017/5/7.
 */
public class CollectionDTO {
    private int id;

    private int users_id;

    private MomentDTO momentDTO;

    private Timestamp create_at;

    public CollectionDTO() {
    }

    public CollectionDTO(int id, int users_id, MomentDTO momentDTO, Timestamp create_at) {
        this.id = id;
        this.users_id = users_id;
        this.momentDTO = momentDTO;
        this.create_at = create_at;
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

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }
}
