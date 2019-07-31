package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Job;


public class JobDAO implements DAO<Job> {

	private final String QUERY_ALL = "SELECT * FROM job";
	private final String QUERY_CREATE = "INSERT INTO job (name, description) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM job WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE job SET name=?, description=?  WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM job WHERE id=?";

	public JobDAO() {

	}

	public List<Job> getAll() {
		List<Job> jobsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Job job;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				job = new Job(name, description);
				job.setId(id);
				jobsList.add(job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobsList;
	}

	public boolean insert(Job jobToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, jobToInsert.getName());
			preparedStatement.setString(2, jobToInsert.getDescription());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Job read(int jobId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, jobId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, description;

			name = resultSet.getString("name");
			description = resultSet.getString("description");
			Job job = new Job(name, description);
			job.setId(resultSet.getInt("id"));

			return job;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Job jobToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (jobToUpdate.getId() == 0)
			return false;

		Job jobRead = read(jobToUpdate.getId());
		if (!jobRead.equals(jobToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (jobToUpdate.getName() == null || jobToUpdate.getName().equals("")) {
					jobToUpdate.setName(jobRead.getName());
				}

				if (jobToUpdate.getDescription() == null || jobToUpdate.getDescription().equals("")) {
					jobToUpdate.setDescription(jobRead.getDescription());
				}

				// Update the Job
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, jobToUpdate.getName());
				preparedStatement.setString(2, jobToUpdate.getDescription());
				preparedStatement.setInt(3, jobToUpdate.getId());
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

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}



}
