package goott.spring.project1.service;

import java.util.List;

import goott.spring.project1.domain.MovieVO;

public interface MovieService {
	public abstract List<MovieVO> read();
	public abstract MovieVO read(String movieId);
	public abstract String readMovieName(String movieId);
}
