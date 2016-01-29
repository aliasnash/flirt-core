package com.fl.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "caption", "dateAdded" })
@ToString
@Entity
@Table(schema = "public", name = "articles")
public class Article {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long          id;
                          
    @Column(name = "idgood", nullable = false)
    private Long          idGood;
                          
    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "idgood", insertable = false, updatable = false)
    // private Good good;
    
    @Column(name = "articlecode", length = 32)
    private String        articleCode;
                          
    @Column(name = "caption", nullable = false)
    private String        caption;
                          
    @Column(name = "istopproduct")
    private Boolean       topProduct;
                          
    @Column(name = "dateadded")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime dateAdded;
}
