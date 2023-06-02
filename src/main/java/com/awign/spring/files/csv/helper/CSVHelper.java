package com.awign.spring.files.csv.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.awign.spring.files.csv.model.User;

public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "name", "mobile", "country" };

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<User> csvToUsers(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<User> users = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        User tutorial = new User(
              Long.parseLong(csvRecord.get("Id")),
              csvRecord.get("name"),
              csvRecord.get("mobile"),
              csvRecord.get("country"),
              Integer.toString(csvRecord.get("mobile").length())
            );

        users.add(tutorial);
      }

      return users;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

}
