package com.citic.pjmgr.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by lan on 6/9/18.
 */
@Entity
@Data
@Table(name = "t_user")

public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "project_name")
    private String projectName;
    @Column(name = "submitter")
    private String submitter;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false, length = 10)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false, length = 10)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    @Column(name = "description", length = 255)
    private String desc;
    @Column(name = "stage_list", length = 255)
    private int[] stageList;

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", submitter='" + submitter + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", desc='" + desc + '\'' +
                ", stageList=" + Arrays.toString(stageList) +
                '}';
    }
}