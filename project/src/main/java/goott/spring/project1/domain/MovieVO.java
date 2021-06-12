package goott.spring.project1.domain;

import java.util.Date;

public class MovieVO {
	private String movieId; // ��ȭ ID
	private int ageLimit; // ��������
	private String movieName; // ��ȭ ����
	private String movieGenre; // ��ȭ �帣
	private String movieSummaryTitle; // ��ȭ �ٰŸ� Ÿ��Ʋ
	private int screenTime; // �󿵽ð�
	private Date releaseDate; // ������
	private String movieCast; // �⿬��
	private int audCount; // ������
	private String movieEngTitle; // ��ȭ ���� ����
	private String movieSummaryContent; // ��ȭ �ٰŸ� ����
	
	public MovieVO() {}
	
	public MovieVO(String movieId, int ageLimit, String movieName, String movieGenre, String movieSummaryTitle,
			int screenTime, Date releaseDate, String movieCast, int audCount, String movieEngTitle,
			String movieSummaryContent) {
		super();
		this.movieId = movieId;
		this.ageLimit = ageLimit;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieSummaryTitle = movieSummaryTitle;
		this.screenTime = screenTime;
		this.releaseDate = releaseDate;
		this.movieCast = movieCast;
		this.audCount = audCount;
		this.movieEngTitle = movieEngTitle;
		this.setMovieSummaryContent(movieSummaryContent);
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public int getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieSummaryTitle() {
		return movieSummaryTitle;
	}

	public void setMovieSummaryTitle(String movieSummaryTitle) {
		this.movieSummaryTitle = movieSummaryTitle;
	}

	public int getScreenTime() {
		return screenTime;
	}

	public void setScreenTime(int screenTime) {
		this.screenTime = screenTime;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}

	public int getAudCount() {
		return audCount;
	}

	public void setAudCount(int audCount) {
		this.audCount = audCount;
	}

	public String getMovieEngTitle() {
		return movieEngTitle;
	}

	public void setMovieEngTitle(String movieEngTitle) {
		this.movieEngTitle = movieEngTitle;
	}

	public String getMovieSummaryContent() {
		return movieSummaryContent;
	}

	public void setMovieSummaryContent(String movieSummaryContent) {
		this.movieSummaryContent = movieSummaryContent;
	}

	@Override
	public String toString() {
		return "MovieVO [movieId=" + movieId + ", ageLimit=" + ageLimit + ", movieName=" + movieName + ", movieGenre="
				+ movieGenre + ", movieSummaryTitle=" + movieSummaryTitle + ", screenTime=" + screenTime
				+ ", releaseDate=" + releaseDate + ", movieCast=" + movieCast + ", audCount=" + audCount
				+ ", movieEngTitle=" + movieEngTitle + ", movieSummaryContent=" + movieSummaryContent + "]";
	}
	
}
