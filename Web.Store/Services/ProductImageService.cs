using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Web.Store.Data;
using Web.Store.Data.Entities;
using Web.Store.Repositories;

namespace Web.Store.Services
{
    public class ProductImageService : IRepository<ProductImage>
    {
        private bool disposed = false;
        private readonly EFAppContext _context;

        public ProductImageService(EFAppContext appContext)
        {
            _context = appContext;
        }

        public async Task CreateAsync(ProductImage item)
        {
            await _context.ProductImages.AddAsync(item);
        }

        public async Task DeleteAsync(int id)
        {
            ProductImage product = await _context.ProductImages.FindAsync(id);
            if (product != null)
            {
                _context.ProductImages.Remove(product);
            }
        }

        protected virtual void Dispose(bool disposing)
        {
            if (!this.disposed)
            {
                if (disposing)
                {
                    _context.Dispose();
                }
            }
            this.disposed = true;
        }
        public void Dispose()
        {
            Dispose(true);
            GC.SuppressFinalize(this);
        }

        public IEnumerable<ProductImage> GetAll()
        {
            return _context.ProductImages.ToList();
        }

        public async Task<ProductImage> GetAsync(int id)
        {
            return await _context.ProductImages.FindAsync(id);
        }

        public async Task SaveAsync()
        {
            await _context.SaveChangesAsync();
        }

        public void Update(ProductImage item)
        {
            _context.Entry(item).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
        }
    }
}
