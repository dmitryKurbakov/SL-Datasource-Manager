package sources;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import helpers.ColumnsPopulate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import dataobject.DataSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileInFileSystem {

    ObservableList rowset;
    DataSource source;
    String filepath;
    Boolean hasHeader;
    List<String[]> rs;

    public ObservableList getRowset() {
        return this.rowset;
    }

    public List<String[]> getRs() {
        return this.rs;
    }

    public DataSource getSource() {
        return this.source;
    }


    public FileInFileSystem(DataSource source, String filepath) {
        this.source = source;

        this.filepath = filepath;

        testConnection();
    }

    public void saveConnection() {
    }

    public ObservableList testConnection() {
        try {
            CSVReader reader = new CSVReader(new FileReader(filepath));

            this.rs = reader.readAll();
            rowset = FXCollections.observableArrayList(rs);

            hasHeader = isExistHeader(rs);
            CSVParser s = reader.getParser();

            ColumnsPopulate cp = new ColumnsPopulate(rs, hasHeader);
            source.getFile_ds().setFile_delimeter(new String(new char[]{s.getSeparator()}));
            source.getFile_ds().setFile_type(getFileType());
            source.getFile_ds().setFile_header(hasHeader);
            source.getFile_ds().setFile_columns(cp.getFileColumns());
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        return rowset;
    }

    private String getFileType() {
        char[] charArr = source.getFile_ds().getFile_delimeter().toCharArray();

        for (char ch: charArr) {
            if (ch < ' ' || ch > ' ') continue;
            else return "fixed";
        }
        return "delimited";
    }

    private boolean isExistHeader(List<String[]> rs) {
        String[] a = rs.get(0);

        try {
            Integer.parseInt(a[0]);
            return false;
        } catch (ParseException ex) {
        }
        return true;
    }

    private String[] columnsName(List<String[]> rs) {
        return rs.get(0);
    }


}//End of class
