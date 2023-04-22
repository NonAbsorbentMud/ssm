package own.cfb.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

//自定义一个TypeHandler用来将javatype的日期类型和jdbctype的VARCHAR进行转换
public class CreateTypeHandlerOne extends BaseTypeHandler<Date> {

    // 设置sql中指定索引的参数，即将javaType转化为jdbcType
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        //设置数据存储到数据库中的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ps.setString(i, sdf.format(parameter));
    }
    // 根据列名称从结果集获取值，并将jdbcType转换成javaType
    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        if (null != columnValue) {
            return new Date(Long.valueOf(columnValue));
        }
        return null;
    }
    // 根据列名称从结果集获取值，并将jdbcType转换成javaType
    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String columnValue = rs.getString(columnIndex);
        if (null != columnValue) {
            return new Date(Long.valueOf(columnValue));
        }
        return null;
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String columnValue = cs.getString(columnIndex);
        if (null != columnValue) {
            return new Date(Long.valueOf(columnValue));
        }
        return null;
    }
}
