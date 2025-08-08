    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (pLevel.isClientSide()) return;

        if (progress > 0 && progress < maxProgress) {
            progress++;
            this.setChanged();
        } else if (progress >= maxProgress) {
            SimpleContainer inputContainer = new SimpleContainer(itemHandler.getSlots());
            for (int i = 0; i < itemHandler.getSlots(); i++) {
                inputContainer.setItem(i, itemHandler.getStackInSlot(i));
            }

            Optional<ForgeBlockRecipe> recipe = pLevel.getRecipeManager()
                    .getRecipeFor(ForgeBlockRecipe.Type.INSTANCE, inputContainer, pLevel);

            if (recipe.isPresent() && recipe.get().matches(inputContainer, pLevel)) {
                craftItem(recipe.get().getResultItem(RegistryAccess.EMPTY));
                recipe.get().getIngredients().forEach(ingredient -> {
                    for (int i = 0; i < itemHandler.getSlots(); i++) {
                        if (ingredient.test(itemHandler.getStackInSlot(i))) {
                            itemHandler.extractItem(i, 1, false);
                            break;
                        }
                    }
                });
            }
            progress = 0;
            this.setChanged();
        }
    }

    public void craftCurrentRecipe(Player player) {
        if (level == null) return;

        SimpleContainer inputContainer = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inputContainer.setItem(i, itemHandler.getStackInSlot(i));
        }

        Optional<ForgeBlockRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ForgeBlockRecipe.Type.INSTANCE, inputContainer, level);

        if (recipe.isPresent() && recipe.get().matches(inputContainer, level)) {
            craftItem(recipe.get().getResultItem(RegistryAccess.EMPTY));
            setChanged();
        }
    }