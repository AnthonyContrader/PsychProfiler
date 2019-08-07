package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Answer;


public class AnswerDAO implements DAO<Answer> {
	
	private final String QUERY_ALL="SELECT * FROM answer";
	private final String QUERY_CREATE="INSERT INTO answer(id_cand,id_quest,ans) VALUES (?,?,?,?) ";
	private final String QUERY_READ="SELECT * FROM answer  WHERE id_ans=?";
	private final String QUERY_UPDATE="UPDATE answer SET id_cand=?, id_quest=?, ans=? ";
	private final String QUERY_DELETE="DELETE FROM answer WHERE id=?";
	
	public AnswerDAO(){
		
	}
	public List<Answer> getAll(){
		List<Answer> answersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Answer answer;
			while(resultSet.next()) {
				int id_ans = resultSet.getInt("id_ans");
				int id_cand= resultSet.getInt("id_cand");
				int id_quest= resultSet.getInt("id_quest");
				int ans = resultSet.getInt("ans");
				answer = new Answer (id_ans, id_cand, id_quest, ans);
				answer.setId_ans(id_ans);
				answersList.add(answer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return answersList;
	}
	@Override
	public boolean insert(Answer answerToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, answerToInsert.getId_cand());
			preparedStatement.setInt(2, answerToInsert.getId_quest());
			preparedStatement.setInt(3, answerToInsert.getAns());
			preparedStatement.execute();
			return true;
		}catch (SQLException e) {
			return false;
		}
		
	}
	@Override
	public Answer read(int id_ans) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id_ans);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int id_cand, id_quest, ans;

			id_cand = resultSet.getInt("id_cand");
			id_quest = resultSet.getInt("id_quest");
			ans = resultSet.getInt("ans");
			Answer answer = new Answer(id_cand, id_quest, ans);
			answer.setId_ans(resultSet.getInt("id_ans"));

			return answer;
		} catch (SQLException e) {
			return null;
		}

		
	}
	
	@Override
	public boolean update(Answer answerToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		if (answerToUpdate.getId_ans() == 0)
			return false;

		 Answer answerRead = read(answerToUpdate.getId_ans());
		if (!answerRead.equals(answerToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (answerToUpdate.getId_cand() == 0) {
					answerToUpdate.setId_cand(answerRead.getId_cand());
				}
				if (answerToUpdate.getId_quest() == 0) {
					answerToUpdate.setId_quest(answerRead.getId_quest());
				}
				if (answerToUpdate.getAns() == 0) {
					answerToUpdate.setAns(answerRead.getAns());
				}

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, answerToUpdate.getId_cand());
				preparedStatement.setInt(2, answerToUpdate.getId_quest());
				preparedStatement.setInt(3, answerToUpdate.getAns());
				preparedStatement.setInt(4, answerToUpdate.getId_ans());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}
	@Override
	public boolean delete(int id_ans) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_ans);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

	
}
