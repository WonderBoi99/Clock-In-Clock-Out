package com.backend.demo.respository;

import com.backend.demo.entity.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * The RecordsRepo class is built to read and manipulate the data in the Records entity in the local MySQL database
 *
 * @author Nikhil Naikar
 * @version 1.0
 * @since Dec.5,2023
 */

public interface RecordsRepo extends JpaRepository<Records, Integer> {

    /**
     * Receives a pin and date, then queries the Records table to get all the records
     * with the matching rows than have the matching pin and date attributes
     *
     * @param pin, an int (dddd)
     * @param date, an String
     * @return return a Records list of the matching queries as mentioned above
     */
    List<Records> findByPinAndDate(int pin, String date);

    /**
     * Receives a pin, then queries the Records table to get all the records
     * with the matching rows than have the matching pin attribute
     *
     * @param pin, an int (dddd)
     * @return return a Records list of the matching queries as mentioned above
     */
    List<Records> findByPin(int pin);

    /**
     * Receives a record which contains new data, then save the new data to the Records table
     *
     * @param record, a Record object
     */
    Records save(Records record);
}
