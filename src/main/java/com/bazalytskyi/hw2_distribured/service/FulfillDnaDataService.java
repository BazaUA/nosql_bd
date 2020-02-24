package com.bazalytskyi.hw2_distribured.service;

import com.bazalytskyi.hw2_distribured.entity.sql.Base;
import com.bazalytskyi.hw2_distribured.entity.sql.BaseRegion;
import com.bazalytskyi.hw2_distribured.entity.sql.RegionGroup;
import com.bazalytskyi.hw2_distribured.entity.sql.Task;
import com.bazalytskyi.hw2_distribured.repository.sql.BaseRegionRepository;
import com.bazalytskyi.hw2_distribured.repository.sql.BaseRepository;
import com.bazalytskyi.hw2_distribured.repository.sql.RegionGroupRepository;
import com.bazalytskyi.hw2_distribured.repository.sql.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class FulfillDnaDataService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private BaseRegionRepository baseRegionRepository;
    @Autowired
    private RegionGroupRepository regionGroupRepository;
    @Autowired
    private BaseRepository baseRepository;


    private Task task;

    public void seedData() {
        createTask();
        File book = new File("result.csv");
        try (FileInputStream inputStream = new FileInputStream(book); Scanner sc = new Scanner(inputStream, "UTF-8")) {
            while (sc.hasNextLine()) {
                processCsvRow(sc.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createTask() {
        task = new Task();
        task.setName("Sardinia and Middle East");
        task.setBaseSequence("ttctttcatggggaagcagatttgggtaccacccaagtattgactcacccatcaaca" +
                "accgctatgtatttcgtacattactgccagccaccatgaatattgtacggtaccataaat" +
                "acttgaccacctgtagtacataaaaacccaatccacatcaaaaccccctccccatgctta" +
                "caagcaagtacagcaatcaaccctcaactatcacacatcaactgcaactccaaagccacc" +
                "cctcacccactaggataccaacaaacctacccacccttaacagtacatagtacataaagc" +
                "catttaccgtacatagcacattacagtcaaatcccttctcgtccccatggatgacccccc" +
                "tcagataggggtcccttgaccaccatcc");
        task.setLength(385);
        task.setOriginStart(16024);
        task.setOriginEnd(16409);
        taskRepository.save(task);
    }

    private void processCsvRow(String nextLine) {
        String[] rowData = nextLine.split(",");
        String baseSource = rowData[0];
        String sequence = rowData[4];
        String[] regions = rowData[5].split(";");
        List<String> localities =
                Arrays.asList(rowData[6].split(";")).stream()
                .map(String::trim)
                .collect(Collectors.toList());
        String[] populations = rowData[7].split(";");
        Base base = new Base();
        base.setSource(baseSource);
        base.setSequence(sequence);
        base.setTaskName(task);

        List<BaseRegion> baseRegions = createRegions(localities);
        base.setRegions(baseRegions);
        base.setPopulation(Integer.valueOf(populations[0]));
        baseRepository.save(base);
    }

    private List<BaseRegion> createRegions(List<String> localities) {
        List<BaseRegion> baseRegions = new ArrayList<>();
        for (String locality : localities) {
            if ("A".equals(locality)){
                continue;
            }
            BaseRegion baseRegion = new BaseRegion();
            baseRegion.setName(locality);
            baseRegionRepository.save(baseRegion);
            baseRegions.add(baseRegion);
        }
        RegionGroup regionGroup = new RegionGroup();
        regionGroup.setName(String.join(" and", localities));
        regionGroup.setRegions(baseRegions);
        regionGroupRepository.save(regionGroup);
        return baseRegions;
    }
}
