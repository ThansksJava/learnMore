package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feng Jie
 * @date 2022/4/19 10:31
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MyClass {
    private int uniqueId;
    public int getUniqueId(){
        return 1000;
    }
}
