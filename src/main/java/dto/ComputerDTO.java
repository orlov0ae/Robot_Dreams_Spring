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
public class ComputerDTO {

    private Long id;
    private String processor;
    private String capacity;
    private List<UserDTO> users;

}
