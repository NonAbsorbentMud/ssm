package own.cfb.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 自定义一个TypeHandler用来将javatype的日期类型和jdbctype的VARCHAR进行转换
 */
public class CreateTypeHandlerTwo implements TypeHandler<Date> {
    @Override
    // 设置sql中指定索引的参数，即将javaType转化为jdbcType
    public void setParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        //设置数据存储到数据库中的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ps.setString(i, sdf.format(parameter));
    }

    @Override
    // 根据列名称从结果集获取值，并将jdbcType转换成javaType
    public Date getResult(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        if (null != columnValue) {
            return new Date(Long.valueOf(columnValue));
        }
        return null;
    }

    @Override
    // 根据列名称从结果集获取值，并将jdbcType转换成javaType
    public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
        String columnValue = rs.getString(columnIndex);
        if (null != columnValue) {
            return new Date(Long.valueOf(columnValue));
        }
        return null;
    }

    @Override
    public Date getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String columnValue = cs.getString(columnIndex);
        if (null != columnValue) {
            return new Date(Long.valueOf(columnValue));
        }
        return null;
    }
}
