public class ProductRepository {

    private Product[] items = new Product[0];

    public void save(Product item) throws AlreadyExistsException {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
        int count = 0;
        for (int j = 0; j < tmp.length; j++) {
            for (int k = j + 1; k < tmp.length; k++) {
                if (tmp[j] == tmp[k]) {
                    count++;
                }
            }
            if (count == item.getId()) {
                throw new AlreadyExistsException("Element with id: " + item.getId() + " not found");
            }
        }
    }

    public Product[] findAll() {
        return items;
    }

    public void removeById(int id) throws NotFoundException {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
