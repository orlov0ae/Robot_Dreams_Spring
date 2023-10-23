package dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDTO {

    private Long id;
    private String name;
    private List<RoleDTO> rolelist;
    private ComputerDTO computer;

}
