package com.example.demo.pojo.user;

public class Permission {
    private Integer id;

    private Integer parentId;

    private String name;

    private String type;

    private Integer sort;

    private String url;

    private String permCode;

    private String icon;

    private String state;

    private String nameEn;

	public Permission (Integer parentId,String name, String type,String url,String permCode){
		this.parentId=parentId;
		this.name=name;
		this.type=type;
		this.url=url;
		this.permCode=permCode;
	}

	public Permission (){

	}
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode == null ? null : permCode.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

}