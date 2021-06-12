package goott.spring.project1.persistence;

import java.util.List;

import goott.spring.project1.domain.MovieVO;

public interface MovieDAO {
	public abstract List<MovieVO> select();
	public abstract MovieVO select(String movieId);
}
