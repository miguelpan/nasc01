package model.dao;
//Departamento � uma entidade do model

import java.util.List;

import model.entities.Department;
// Interface DepartmentDao
public interface DepartmentDao {

	void insert(Department obj);//Opera��o responsavel por inserir um registro no banco de dados um objeto passado como parametro
	void update(Department obj);//Opera��o responsavel por atualizar um registro no banco de dados um objeto passado como parametro
	void deleteById(Integer id);//Opera��o responsavel por deletar um registro no banco de dados um objeto passado como parametro
	Department findById(Integer id);//Opera��o responsavel por pegar um ID e consultar o banco de dados com esse ID
	List<Department> findAll();//Opera��o responsavel por retornar todos os registro do banco de dados 
}
