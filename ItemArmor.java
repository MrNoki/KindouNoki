{package net.minecraft.server;

public class ItemArmor extends Item
{
  private static final int[] co = { 11, 16, 15, 13};
  public final int a;
  public final int b;
  public final int c;
  private final EnumArmorMaterial cp;

  public ItemArmor(int paramInt1, EnumArmorMaterial paramEnumArmorMaterial, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.cp = paramEnumArmorMaterial;
    this.a = paramInt3;
    this.c = paramInt2;
    this.b = paramEnumArmorMaterial.b(paramInt3);
    setMaxDurability(paramEnumArmorMaterial.a(paramInt3));
    this.maxStackSize = 1;
    a(CreativeModeTab.j);
  }

  public int c()
  {
    return this.cp.a();
  }

  public EnumArmorMaterial d() {
    return this.cp;
  }

  public boolean a(ItemStack paramItemStack) {
    if (this.cp != EnumArmorMaterial.CLOTH) return false;
    if (!paramItemStack.hasTag()) return false;
    if (!paramItemStack.getTag().hasKey("display")) return false;
    return paramItemStack.getTag().getCompound("display").hasKey("color");
  }

  public int b(ItemStack paramItemStack)
  {
    if (this.cp != EnumArmorMaterial.CLOTH) return -1;

    NBTTagCompound localNBTTagCompound1 = paramItemStack.getTag();
    if (localNBTTagCompound1 == null) return 10511680;
    NBTTagCompound localNBTTagCompound2 = localNBTTagCompound1.getCompound("display");
    if (localNBTTagCompound2 == null) return 10511680;

    if (localNBTTagCompound2.hasKey("color")) {
      return localNBTTagCompound2.getInt("color");
    }
    return 10511680;
  }

  public void c(ItemStack paramItemStack)
  {
    if (this.cp != EnumArmorMaterial.CLOTH) return;
    NBTTagCompound localNBTTagCompound1 = paramItemStack.getTag();
    if (localNBTTagCompound1 == null) return;
    NBTTagCompound localNBTTagCompound2 = localNBTTagCompound1.getCompound("display");
    if (localNBTTagCompound2.hasKey("color")) localNBTTagCompound2.o("color"); 
  }

  public void b(ItemStack paramItemStack, int paramInt)
  {
    if (this.cp != EnumArmorMaterial.CLOTH) throw new UnsupportedOperationException("Can't dye non-leather!");

    NBTTagCompound localNBTTagCompound1 = paramItemStack.getTag();

    if (localNBTTagCompound1 == null) {
      localNBTTagCompound1 = new NBTTagCompound();
      paramItemStack.setTag(localNBTTagCompound1);
    }

    NBTTagCompound localNBTTagCompound2 = localNBTTagCompound1.getCompound("display");
    if (!localNBTTagCompound1.hasKey("display")) localNBTTagCompound1.setCompound("display", localNBTTagCompound2);

    localNBTTagCompound2.setInt("color", paramInt);
  }

  public boolean a(ItemStack paramItemStack1, ItemStack paramItemStack2)
  {
    if (this.cp.b() == paramItemStack2.id) {
      return true;
    }
    return super.a(paramItemStack1, paramItemStack2);
  }
  
  static int[] e() {
      return co;
  }  
}
