package fun.lain.mizuki.misuki.moudels.document.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@TableName("document_info")
public class DocumentInfo {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String tags;
    private String cover;
    private String files;
    private String introduce;
    private String article;
    private String type;
    private String status;
    private String remarks;
    private Long userId;
    private String length;
    private String author;
}
