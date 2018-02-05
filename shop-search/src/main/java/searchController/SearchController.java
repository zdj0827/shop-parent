package searchController;

import dto.SearchResult;
import interfaces.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @Autowired
    private SearchItemService searchItemService;

    //全文检索，模糊查询
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String searchItemList(String keyword,
                                 @RequestParam(defaultValue = "1")Integer page, Model model){

        System.out.println(keyword);
        if(keyword!=null) {
            SearchResult searchResult = searchItemService.searchItemList(keyword, page, 60);
            model.addAttribute("query",keyword);
            model.addAttribute("page",page);
            model.addAttribute("totalPages",searchResult.getTotalPages());
            model.addAttribute("recordCount",searchResult.getRecordCount());
            model.addAttribute("itemList",searchResult.getItemList());
        }
        return "search";
    }
}
