import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {
    Optional<UploadedFile> findByFileName(String fileName);
    boolean existsByFileName(String fileName);
    Optional<UploadedFile> findByFileType(String fileType);
    Optional<UploadedFile> findByUploadDate(String uploadDate);
}
