package com.eshore.project.springbootdemo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lixinxin
 * @since 2020-01-03
 */
@ApiModel
@TableName("tb_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.UUID)
    private String id;
    /**
     * 姓名
     */
    @ApiModelProperty(name = "username",value = "姓名")
    @TableField("username")
    private String userName;
    @TableField("passWord")
    private String passWord;
    @TableField("pattern_lock")
    private String patternLock;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPatternLock() {
        return patternLock;
    }

    public void setPatternLock(String patternLock) {
        this.patternLock = patternLock;
    }

    public User(String userName, String passWord, String patternLock) {
        this.userName = userName;
        this.passWord = passWord;
        this.patternLock = patternLock;
    }

    public User(String id, String userName, String passWord, String patternLock) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.patternLock = patternLock;
    }

    public User(){} //无参构造

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", username=" + userName +
        ", password=" + passWord +
        ", patternLock=" + patternLock +
        "}";
    }
}
