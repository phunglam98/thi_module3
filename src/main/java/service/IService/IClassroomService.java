package service.IService;

import java.util.List;

public interface IClassroomService<E> {
    List<E> findAll();
}
