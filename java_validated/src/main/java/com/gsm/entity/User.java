package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * @AssertFalse         Boolean，boolean     验证注解元素是false
 * @AssertTrue          Boolean，boolean     验证注解元素是true
 * @NotNull             任意类型              验证元素值不为null,可以为空字符串
 * @Null                任意类型              验证元素值为null
 * @Min(value=值)       数值类                验证元素的值大于等于 value的值
 * @Max(value=值)       数值类                验证元素的值小于等于 value的值
 * @DecimalMin(value=值)数值类                验证元素的值小于等于 value的值
 * @DecimalMax(value=值)数值类                验证元素的值小于等于 value的值
 * @Digits(integer=整数位数，fraction=小数位数) 验证元素的值整数位数和小数位数上线
 * @Size(min=值，max=值) 字符串,Collection,Map,数组     验证元素的值在min和max之间,字符串长度,数组大小等
 * @Past()              日期类                验证注解的元素比当前时间早
 * @Future()            日期类                验证注解的元素比当前时间晚
 * @NotBlank()          CharSequence子类型    验证元素不为空（不为null,trim之后不能为0）
 * @NotEmpty()          CharSequence子类型,集合,Map,数组       验证元素不为null且不为空(字符串长度不为0，可以为空字符串,集合个数不为0)
 * @Length(min=下限,max=上限)   字符串类        验证元素长度在区间内
 * @Range(min=下限,max=上限)    数值类，字符串类  验证注解元素在区间内
 * @Email(regexp=正则)    字符串类              验证元素是email。可以通过正则指定规范
 * @Pattern(regexp=正则)  字符串类              验证元素与正则指定规范
 * @Valid               非原子类型,自定义类型     验证递归关联对象，例如User有一个子属性Car,想验证Car可用@Valid关联验证
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    public interface insert{}

    public interface update{}

    /**
     *
     */
    @NotBlank(message = "userId不能为空",groups = update.class)
    private String userId;
    /**
     *
     */
    @Size(min = 1,max = 5,message = "name值的范围[1,5]",groups = insert.class)
    @Size(min = 2,max = 3,message = "name值的范围[2,3]",groups = update.class)
    private String name;
    /**
     *
     */
    @NotNull(message = "nil不能为空",groups = insert.class)
    @NotNull(message = "nil不能为空",groups = update.class)
    private String nil;
    /**
     *
     */
    @NotBlank(message = "blank不能为空",groups = insert.class)
    @NotBlank(message = "blank不能为空",groups = update.class)
    private String blank;
    @NotEmpty(message = "nickName不能为空",groups = insert.class)
    @NotEmpty(message = "nickName不能为空",groups = update.class)
    private String nickName;

    private Date birthday;
    @Length(min = 1,max = 20,message = "密码长度为[1,20]",groups = insert.class)
    @Length(min = 1,max = 20,message = "密码长度为[1,20]",groups = update.class)
    private String pwd;
    @Email(message = "邮箱格式错误",groups = insert.class)
    @Email(message = "邮箱格式错误",groups = update.class)
    private String email;
    @AssertFalse
    private Boolean flag;

    @Valid
    private Car car;
}
