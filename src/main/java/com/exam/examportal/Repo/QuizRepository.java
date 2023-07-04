package com.exam.examportal.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examportal.model.exam.Category;
import com.exam.examportal.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long>{
	public List<Quiz> findBycategory(Category category);
	public List<Quiz> findByActive(Boolean b);
//	public List<Quiz> findByshowResult(Boolean b);
	public List<Quiz> findByCategoryAndActive(Category c, Boolean b);
}

