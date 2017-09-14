/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

// Import classes referenced and libraries utilized in DAO implementation
import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 *
 * @author jeffc
 */
public class DVDLibraryDaoFileImpl2 implements DVDLibraryDao {
    // Declare HashMap to store DVD SKUs as keys and DVD objects as values
    private Map<String, DVD> dvds = new HashMap<>();
    // Initialize name of write file as a static final
    public static final String ADDRESS_FILE = "dvds.txt";
    // Initialize data file delimiter as a static final
    public static final String DELIMITER = "::";
    // Initialize integer to count and generate unique SKU codes
    private Integer nextSKU = 0;
    
    // Construct DVDLibraryDaoFileImpl object and unmarshal data from file to dvds HashMap
    public void DVDLibraryDaoFileImpl()
     throws DVDLibraryDaoException {
        loadLibrary();
    }

    @Override // Add a new DVD object to the dvds HashMap
    public DVD addDVD(String SKU, DVD dvd) 
     throws DVDLibraryPersistenceException {
        DVD currentDVD = dvds.put(SKU, dvd);
        return currentDVD;
    }

    @Override // Returns an ArrayList of all DVD object values in dvds HashMap
    public List<DVD> getAllDVDs() 
     throws DVDLibraryPersistenceException {
        return new ArrayList(dvds.values());
    }

    @Override // Returns a DVD object from dvds Hashmap based on SKU key
    public DVD getDVD(String SKU) 
     throws DVDLibraryPersistenceException {
        return dvds.get(SKU);
    }

    @Override // removes a DVD object and its SKU key from dvds HashMap based
              // on passed in SKU
    public DVD removeDVD(String SKU) 
     throws DVDLibraryPersistenceException {
        DVD removedDVD = dvds.remove(SKU);
        return removedDVD;
    }
    
    @Override // Builds an ArrayList of DVD search results by title
              // in dvds HashMap and returns it
    public List<DVD> getDVDsByTitle(String title)
     throws DVDLibraryPersistenceException {
        // Instantiate search result list
        List<DVD> dvdSearchResults = new ArrayList<>();
        // Search through dvds HashMap and DVD objects with correct title to ArrayList
        dvds.values().stream().filter((currentDVD) -> (currentDVD.getTitle().equals(title))).forEachOrdered((currentDVD) -> {
            dvdSearchResults.add(currentDVD);
        });
        // Return the Arraylist
        return (dvdSearchResults);
    }
    
    @Override // Creates a new, unique SKU, concatenates it to "DL", and returns it as a String
    public String getNewSKU() {
        // Increment SKU generator
        nextSKU++;
        return ("DL" + nextSKU);
    }
    
    @Override // Checks if an SKU exists in the dvds Hashamp and returns
              // true if it does and false if it does not
    public boolean verifySKU(String SKU) {
        return dvds.containsKey(SKU);
    }
    
    @Override // Calls the private method to marshal DVD object data to data file
    public void saveOnExit() 
     throws DVDLibraryPersistenceException {
        writeLibrary();
    }
    
    // Unmarhsalls DVD object data from data file
    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;
        
        // Tries&Catches FileNotFoundException and translates it to DaoException
        // to maintain loose coupling between program layers
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                "-_- Could not load roster data into memory.", e);
        }
        
        // Declares a string to hold the data file data line by line
        String currentLine;
        // If there is data in the file, read in the first line as a string
        // and parse it to an integer to save in the SKU generator.
        // The first line of the data file represents the number of SKUs
        // generated in the program's history so that they will not be duplicated
        if (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            nextSKU = Integer.parseInt(currentLine);
        }
        // Declares a string array to hold data field data as tokens
        String[] currentTokens;
        // Reads in each existing line of data file, which represents a DVD object, 
        // and splits string into tokens representing each individual field of an object
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            // Splits string to tokens and throws away delimiters
            currentTokens = currentLine.split(DELIMITER);
            // Create new DVD object based on unique SKU
            DVD currentDVD = new DVD(currentTokens[0]);
            // Set all DVD object fields from remaining tokens
            currentDVD.setTitle(currentTokens[1]);
            currentDVD.setReleaseDate(LocalDate.parse(currentTokens[2]));
            currentDVD.setMPAARating(currentTokens[3]);
            currentDVD.setDirector(currentTokens[4]);
            currentDVD.setStudio(currentTokens[5]);
            currentDVD.setUserNote(currentTokens[6]);
            // Add new DVD object to HashMap
            dvds.put(currentDVD.getSKU(), currentDVD);
        }
        // Close the scanner stream
        scanner.close();
        
    }
    
    // Marshals data from student object fields to data file
    private void writeLibrary() throws DVDLibraryPersistenceException {
        PrintWriter out;
        
        // Tries&Catches IOException and translates it to DaoException
        // to maintain loose coupling between program layers
        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new DVDLibraryPersistenceException(
                    "Could not save dvd data.", e);
        }
        // First line printed to file is current value of SKU generator
        out.println(nextSKU);
        // Get Arraylist of all DVD objects in dvds HashMap
        List<DVD> dvdList = this.getAllDVDs();
        // Get fields from all DVD objects in list and write them to lines of
        // data file with each field separated by delimiter.
        dvdList.stream().map((currentDVD) -> {
            out.println(currentDVD.getSKU() + DELIMITER
                    + currentDVD.getTitle() + DELIMITER
                    + currentDVD.getReleaseDate() + DELIMITER
                    + currentDVD.getMPAARating() + DELIMITER
                    + currentDVD.getDirector() + DELIMITER 
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getUserNote());
            return currentDVD;
        }).forEachOrdered((_item) -> {
            // Force PrintWriter to finish writing file
            out.flush();
        });
        // Close data stream
        out.close();
    }

    @Override
    public List<DVD> getAllMoviesReleasedInLastNYears(int N) throws DVDLibraryPersistenceException {
        LocalDate startingDate = LocalDate.now().minusYears(N);
        
        return dvds.values()
                .stream()
                .filter(d -> d.getReleaseDate().toEpochDay() > startingDate.toEpochDay())
                .collect(Collectors.toList());
    }

    @Override
    public List<DVD> getAllMoviesWithGivenMPAARating(String MPAARating) throws DVDLibraryPersistenceException {
        return dvds.values()
                .stream()
                .filter(d -> d.getMPAARating().equalsIgnoreCase(MPAARating))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<DVD>> getAllMoviesByGivenDirectorSortedByMPAARating(String Director) throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getAllMoviesReleasedByStudio(String Studio) throws DVDLibraryPersistenceException {
            return dvds.values()
                .stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(Studio))
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageAgeOfAllMovies() throws DVDLibraryPersistenceException {
        List<DVD> dvdList = getListOfDVDs();
        
        LongSummaryStatistics lstats = dvdList.stream()
            .collect(Collectors.summarizingLong(DVD::getDVDAge));
            
        return lstats.getAverage();
    }

    @Override
    public List<DVD> getListOfDVDs () throws DVDLibraryPersistenceException {
        return dvds.values().stream()
                .collect(Collectors.toList());
    }
    
    
    @Override
    public List<DVD> getNewestMovie() throws DVDLibraryPersistenceException{
        
            List<DVD> dvdList = getListOfDVDs();
//            List<Long> agesList = Lambda.extract(dvdList, Lambda.on(DVD).getDVDAge);

            LongSummaryStatistics lstats = dvdList.stream()
                    .collect(Collectors.summarizingLong(DVD::getDVDAge));
            
            
            long oldestDate = lstats.getMin();
            
            return dvds.values()
                .stream()
                .filter(d -> d.getDVDAge() == oldestDate)
                .collect(Collectors.toList());

//        LocalDate newestDVDs = dvds.values()
//            .stream()
//            .min(DVD::getReleaseDate)
//            .getAsLocalDate().toEpochDay();
//        
//        return dvds.values()
//                .stream()
//                .filter(d -> d.getReleaseDate().toEpochDay() == newestDVDs.toEpochDay())
//                .collect(Collectors.toList());

//               .stream()
//                .mapToLong(Server::getServerAge)
//                .average()
//                .getAsDouble();
    }
    
    @Override
    public List<DVD> getOldestMovie() throws DVDLibraryPersistenceException {
            
//        Comparator<DVD> byRelease = Comparator.comparing(
//                    DVD::getDVDAge, (d1, d2) -> {
//                        return d2.compareTo(d1);
//                    });
//            
//            DVD oldestDVD = getListOfDVDs().stream()
//                    .max(byRelease).get();
//            
//            LocalDate oldestDate;
//                oldestDate = oldestDVD.getReleaseDate();
           


            List<DVD> dvdList = getListOfDVDs();
//            List<Long> agesList = Lambda.extract(dvdList, Lambda.on(DVD).getDVDAge);

            LongSummaryStatistics lstats = dvdList.stream()
                    .collect(Collectors.summarizingLong(DVD::getDVDAge));
            
            
            long oldestDate = lstats.getMax();
            
            return dvds.values()
                .stream()
                .filter(d -> d.getDVDAge() == oldestDate)
                .collect(Collectors.toList());
        
    }

    @Override
    public double getAverageNumberOfNotesPerMovie() throws DVDLibraryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

