package sohu.test;

import net.sf.jsqlparser.*;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectVisitor;
import net.sf.jsqlparser.util.TablesNamesFinder;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;
import net.sf.jsqlparser.util.deparser.SelectDeParser;

import java.io.StringReader;
import java.util.*;

/**
 * Created by qigao212074 on 2016/8/31.
 */
public class Test {

    //  解析用户发送sql语句，获得用户所查询的表。以及获得所需要的列
    public static void parserSQL(String sql){
//      mapTable获得表名和别名的一个map
        Map mapTable = new HashMap();
        String tableName ;
//      select p.name,o.officedesc from person as p,office as o where p.officeID=o.id
//      select * from person
        if(sql.contains("as")){
//          System.out.println("1:"+sql.substring(sql.indexOf("from")+4,sql.indexOf("where")).trim());

            String s = sql.substring(sql.indexOf("from")+4,sql.indexOf("where")).trim();
            String str[] = s.split(",");
            for(String st:str){
//              string数组为获得表,map存表和简写对应关系
                mapTable.put(st.substring(st.indexOf("as")+2, st.length()).trim(),st.substring(0, st.indexOf("as")-1));
//              System.out.println("get the table: "+st.substring(0,st.indexOf("as")-1));
            }
        }else{
//          System.out.println(sql.substring(sql.indexOf("from")+4,sql.length()).trim());
            tableName = sql.substring(sql.indexOf("from")+4,sql.length()).trim();
            System.out.println("表名："+tableName);
        }

//      System.out.println("table size is : "+mapTable.size());


        Iterator it = mapTable.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry m=(Map.Entry)it.next();
            System.out.println(m.getKey()+"    "+m.getValue());
        }

//      解析sql语句中所含有的列名
//      select p.*,o.officedesc from person as p,office as o where p.officeID=o.id
//      if(sql.contains("*")){
//          System.out.println(sql.substring(sql.indexOf("select")+6,sql.indexOf("from")).trim());
        if(sql.contains(".")){
            String tableMsg = sql.substring(sql.indexOf("select")+6,sql.indexOf("from")).trim();
            String s [] = tableMsg.split(",");
//              mapColumns获得表别名和所需要的列名,使用IdentityHashMap的方法，对于有重复的KEY进行处理。
//              如果采用hashmap会对其进行覆盖。
            Map mapColumns = new IdentityHashMap();
            for(String s1:s){
                System.out.println("000000");
                mapColumns.put(s1.substring(0, s1.indexOf(".")), s1.substring(s1.indexOf(".")+1,s1.length()));
            }
            System.out.println(mapColumns);
//              System.out.println("columns size : " + mapColumns.size());
                /*for(Object obj : mapColumns.keySet()){
                      Object value = mapColumns.get(obj );
                      System.out.println("values:"+value);
                }*/

                /*for(Map.Entry entry:mapColumns.entrySet()){
                    System.out.println(entry.getKey()+"="+entry.getValue());
                    }*/

            System.out.println(mapColumns.size());
            Iterator iterator = mapColumns.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry m=(Map.Entry)iterator.next();
                System.out.println("table :"+mapTable.get(m.getKey()));
//                  System.out.println(m.getKey()+"    "+m.getValue());
                System.out.println("columns:"+m.getValue());
            }
        }
//      }else{
//          System.out.println(sql.substring(sql.indexOf("select")+6,sql.indexOf("from")).trim());
//
//      }


    }

    public static List<String> getTableNameBySql(String sql) throws JSQLParserException {
        CCJSqlParserManager parser=new CCJSqlParserManager();
        StringReader reader=new StringReader(sql);
        List<String> list=new ArrayList<String>();
        Statement stmt=parser.parse(new StringReader(sql));
        if (stmt instanceof Select) {
            Select selectStatement = (Select) stmt;
            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
            List tableList = tablesNamesFinder.getTableList(selectStatement);
            for (Iterator iter = tableList.iterator(); iter.hasNext();) {
                String tableName=iter.next().toString();
                System.out.println(tableName);
                list.add(tableName);
            }
        }
        return list;
    }

    public static void main(String[] args) throws JSQLParserException
    {
        // TODO Auto-generated method stub
        String statement="SELECT LOCATION_D.REGION_NAME," +
                " LOCATION_D.AREA_NAME, COUNT(DISTINCT INCIDENT_FACT.TICKET_ID)" +
                " FROM LOCATION_D, INCIDENT_FACT WHERE ( LOCATION_D.LOCATION_SK=INCIDENT_FACT.LOCATION_SK ) and b=1 and c=1" +
                " GROUP BY LOCATION_D.REGION_NAME, LOCATION_D.AREA_NAME";
        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        Select select=(Select) parserManager.parse(new StringReader(statement));

        PlainSelect plain=(PlainSelect)select.getSelectBody();
        List selectitems=plain.getSelectItems();
        System.out.println(selectitems.size());
//        for(int i=0;i<selectitems.size();i++) {
//            Expression expression=((SelectExpressionItem) selectitems.get(i)).getExpression();
//            System.out.println("Expression:-"+expression);
//            Column col=(Column)expression;
//            System.out.println(col.getTable()+","+col.getColumnName());
//        }

        Expression expression = plain.getWhere();
        ExpressionVisitor expressionVisitor = new ExpressionDeParser();
//        Table table = new Table("a");
//        expressionVisitor.visit(new Column(table, "c1"));
        EqualsTo equalsTo = new EqualsTo();
        equalsTo.setLeftExpression(new StringValue("aaaaa"));
        equalsTo.setRightExpression(new StringValue("wawawa"));

        AndExpression andExpression = new AndExpression(expression, equalsTo);
        andExpression.setLeftExpression(expression);
        andExpression.setRightExpression(equalsTo);

//        expressionVisitor.visit(equalsTo);
//        expression.accept(expressionVisitor);
        System.out.println("Expression:-"+andExpression);
    }
}
