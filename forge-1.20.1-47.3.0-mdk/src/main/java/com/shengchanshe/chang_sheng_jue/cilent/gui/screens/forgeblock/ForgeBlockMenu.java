    public void setCurrentRecipe(ForgeRecipe recipe) {
        this.currentRecipe = recipe;
        updateRecipeSlots();

        if (!level.isClientSide) {
            blockEntity.setChanged();
        }
    }

    void updateRecipeSlots() {
        clearAllSlots();
        
        /*if (currentRecipe != null) {
            Level level = Minecraft.getInstance().level;
            if (level == null) return;

            Optional<ForgeBlockRecipe> recipe = level.getRecipeManager()
                    .getRecipeFor(ForgeBlockRecipe.Type.INSTANCE, new SimpleContainer(9), level);

            recipe.ifPresent(recipe1 -> {
                NonNullList<Ingredient> ingredients = recipe1.getIngredients();
                for (int i = 0; i < ingredients.size() && i < 9; i++) {
                    int finalI = i;
                    blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
                        handler.insertItem(finalI, ingredients.get(finalI).getItems()[0].copy(), false);
                    });
                }
            });
        }*/
    }

    // 删除整个hasEnoughMaterials和consumeMaterials方法
    // 删除static块中的所有硬编码配方注册
