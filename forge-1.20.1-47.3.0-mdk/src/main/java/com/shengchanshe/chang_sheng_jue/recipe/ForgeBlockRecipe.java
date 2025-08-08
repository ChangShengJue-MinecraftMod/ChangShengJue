    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) return false;
        
        // 确保容器大小匹配
        if (pContainer.getContainerSize() != inputItems.size()) return false;
        
        // 逐个检查材料匹配
        for (int i = 0; i < inputItems.size(); i++) {
            if (!inputItems.get(i).test(pContainer.getItem(i))) return false;
        }
        return true;
    }

    // 在Type类中添加toString重写
    public static final class Type implements RecipeType<ForgeBlockRecipe> {
        @Override
        public String toString() {
            return "forge_block";
        }
    }