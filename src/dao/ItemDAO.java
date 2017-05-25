/**
 *
 */
package com.internousdev.info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.info.dto.ItemDTO;
import com.internousdev.util.DBConnector;

/**
 * itemテーブルに関するDAOクラス
 * @author BABATAKUMA
 *@since 2017/4/27
 */
public class ItemDAO {

	/**
	 * 商品名を基に商品名を挿入するメソッド
	 * @param itemName　商品名
	 * @return count 実行回数
	 */
	public int insert(String itemName){
		DBConnector db=new DBConnector("infocom");
		Connection con =db.getConnection();
		int count =0;
		String sql ="insert into item(item_name) values (?)";
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, itemName);

			count=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return count;
	}


	/**
	 * 商品名を基に商品を検索するメソッド
	 * @param itemName　商品名
	 * @return itemId 商品ID
	 */
	public int itemSelect(String itemName){
		DBConnector db=new DBConnector("infocom");
		Connection con =db.getConnection();
		int itemId=0;
		String sql="select * from item where item_name=?";
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, itemName);
			ResultSet rs = ps.executeQuery();
			rs.next();
			itemId=rs.getInt("item_id");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return itemId;
	}


	/**
	 * 商品IDを基にその商品の情報を取得するメソッド
	 * @param itemId 商品ID
	 * @return　list 情報の入ったリスト
	 */
	public ArrayList<ItemDTO> itemSelect(int itemId){
		ArrayList<ItemDTO> list=new ArrayList<>();
		String sql=null;
		PreparedStatement ps=null;

		DBConnector db=new DBConnector("infocom");
		Connection con =db.getConnection();


		try{
			if(itemId==0){
				sql="select * from item";
				ps=con.prepareStatement(sql);
			}
			else{
				sql="select * from item where item_id=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1, itemId);
			}


			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				ItemDTO dto=new ItemDTO();

				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemDetail01(rs.getString("item_detail01"));
				dto.setItemDetail02(rs.getString("item_detail02"));
				dto.setLevel(rs.getInt("level"));
				dto.setStatus(rs.getString("status"));

				list.add(dto);
			}

		}catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<ItemDTO> allSelect(){
		ArrayList<ItemDTO> list=new ArrayList<>();
		DBConnector db =new DBConnector("infocom");
		Connection con=db.getConnection();
		String sql="select * from item";

		try {
			PreparedStatement ps=con.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				ItemDTO dto=new ItemDTO();
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemImg01(rs.getString("item_img01"));
				dto.setItemDetail01(rs.getString("item_detail01"));
				dto.setItemDetail02(rs.getString("item_detail02"));
				dto.setLevel(rs.getInt("level"));
				dto.setStatus(rs.getString("status"));
				dto.setItemImg01(rs.getString("item_img01"));

				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		return list;
	}

	public int update(int itemId,int level,String itemName,String itemImg01,String itemDetail01,String itemDetail02,String status){
		int count=0;
		DBConnector db =new DBConnector("infocom");
		Connection con=db.getConnection();
		String sql="update item set level=?,item_name=?,item_img01=?,item_detail01=?,item_detail02=?,status=? where item_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, level);
			ps.setString(2, itemName);
			ps.setString(3, itemImg01);
			ps.setString(4, itemDetail01);
			ps.setString(5, itemDetail02);
			ps.setString(6, status);
			ps.setInt(7, itemId);

			count=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;

	}

	/**
	 * 商品検索用のメソッド
	 * @param name　検索
	 * @return　list 検索結果
	 * @throws SQLException　例外処理
	 */
	public ArrayList<ItemDTO> selectItem(String name) throws SQLException{
		ArrayList<ItemDTO> list=new ArrayList<>();
		PreparedStatement ps=null;
		DBConnector db =new DBConnector("infocom");
		Connection con=db.getConnection();
		if(name !=null){
		String sql="SELECT * FROM item WHERE CONCAT(`item_name`, `item_detail01`, `item_detail02`,'status') LIKE ?";
		ps=con.prepareStatement(sql);

		String select="%"+name+"%";
		ps.setString(1, select);
		}else{
			String sql="select * from item";
			ps=con.prepareStatement(sql);
		}
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			ItemDTO dto=new ItemDTO();
			dto.setItemId(rs.getInt("item_id"));
			dto.setItemName(rs.getString("item_name"));
			dto.setItemDetail01(rs.getString("item_detail01"));
			dto.setItemDetail02(rs.getString("item_detail02"));
			dto.setLevel(rs.getInt("level"));
			dto.setStatus(rs.getString("status"));
			list.add(dto);
		}
		con.close();

		return list;
	}

}
