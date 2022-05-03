package p.ucss.dao;


import java.util.List;
import p.ucss.entity.Post;


/**
 *
 * @author admin
 */
public interface PostDao {
    int create(Post post);
    int update(Post post);
    int delete(int id);
    Post read(int id);
    List<Post> readAll();
}
