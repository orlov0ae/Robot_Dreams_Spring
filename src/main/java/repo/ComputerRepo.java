package repo;

import entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepo extends JpaRepository<Computer, Long> {

    List<Computer> findByProcessorContaining(String processorFragment);

}
