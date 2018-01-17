package string.builder;

public class MyStringBuilder {


    // String builder sql insert
    public String insertStringBuilder(String table, String[] attributes) {

        StringBuilder insert = new StringBuilder();

        insert.append("INSERT INTO ").append(table).append(" (");

        for (int i = 0; i < attributes.length; i++) {
            insert.append(attributes[i]);
            if (i != attributes.length - 1) {
                insert.append(", ");
            } else {
                insert.append(")");
            }
        }

        insert.append(" VALUE").append(" (");
        for (int i = 0; i < attributes.length; i++) {
            insert.append("?");
            if (i != attributes.length - 1) {
                insert.append(", ");
            } else {
                insert.append(")");
            }

        }
        return insert.toString();
    }
    // String builder sql select
    public String selectStringBuilder(String table) {
        StringBuilder select = new StringBuilder();
        select.append("SELECT * FROM ").append(table);
        return select.toString();
    }

    // String builder sql select where key
    public String selectWhereStringBuilder(String table, String key) {
        StringBuilder selectWhere = new StringBuilder();
        selectWhere.append("SELECT * FROM ").append(table).append(" WHERE ").append(key).append("=?");
        return selectWhere.toString();
    }

    // String builder sql update by key
    public String updateStringBuilder(String table, String[] attributes, String key) {

        StringBuilder update = new StringBuilder();

        update.append("UPDATE ").append(table).append(" SET ");
        for (int i = 0; i < attributes.length; i++) {
            update.append(attributes[i]);
            if (i != attributes.length - 1) {
                update.append("=").append("?").append(", ");
            } else {
                update.append("=").append("?");
            }

        }
        update.append(" WHERE ").append(key).append("=").append("?");
        return update.toString();
    }

    // String builder sql update one filed by key
    public String updateStatusStringBuilder(String table, String attribute , String key) {
        StringBuilder update = new StringBuilder();
        update.append("UPDATE ").append(table).append(" SET ").append(attribute).append("=").append("?").append(" WHERE ").append(key).append("=").append("?");
        return update.toString();
    }

    // String builder sql delete by key
    public String deleteWhereStringBuilder(String table, String key) {
        StringBuilder deleteWhere = new StringBuilder();
        deleteWhere.append("DELETE FROM ").append(table).append(" WHERE ").append(key).append("=").append("?");
        return deleteWhere.toString();
    }


}


